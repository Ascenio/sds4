import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

export default function DataTable() {
  const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<SalePage>({
    first: true,
    last: true,
    number: 0,
    numberOfElements: 0,
    content: [],
    empty: true,
    size: 0,
  });

  useEffect(() => {
    (async () => {
      const response = await axios.get(
        `${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`
      );
      console.log(response);
      setPage(response.data);
    })();
  }, [activePage]);

  const changePage = (pageNumber: number) => setActivePage(pageNumber);

  return (
    <>
      <Pagination page={page} onPageChanged={changePage} />
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>Data</th>
              <th>Vendedor</th>
              <th>Clientes visitados</th>
              <th>Negócios fechados</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody>
            {page.content.map((content) => (
              <tr key={content.id}>
                <td>{formatLocalDate(content.date, "dd/MM/yyyy")}</td>
                <td>{content.sellerDTO.name}</td>
                <td>{content.visited}</td>
                <td>{content.deals}</td>
                <td>{content.ammount.toFixed(2)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}
