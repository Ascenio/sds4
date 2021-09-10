import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSuccess } from "types/sale";
import { round } from "utils/format";
import { BASE_URL } from "utils/requests";

type ChartData = {
  labels: {
    categories: string[];
  };
  series: {
    name: string;
    data: number[];
  }[];
};

export default function BarChart() {
  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  const [chartData, setChartData] = useState<ChartData>({
    labels: { categories: [] },
    series: [],
  });

  useEffect(() => {
    (async () => {
      const response = await axios.get(`${BASE_URL}/sales/success-by-seller`);
      const data = response.data as SaleSuccess[];
      const labels = data.map((sale) => sale.sellerName);
      const series = data.map((sale) =>
        round((100 * sale.deals) / sale.visited, 1)
      );
      setChartData({
        labels: { categories: labels },
        series: [{ name: "% Sucesso", data: series }],
      });
    })();
  }, []);

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
}
