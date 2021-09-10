import axios from "axios";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

type ChartData = {
  series: number[];
  labels: string[];
};

export default function DonutChart() {
  let chartData: ChartData = {
    series: [],
    labels: [],
  };

  axios.get(`${BASE_URL}/sales/ammount-by-seller`).then((response) => {
    const data = response.data as SaleSum[];
    chartData = data.reduce<ChartData>(
      (chartData, sale) => {
        const { series, labels } = chartData;
        return {
          series: [...series, sale.sum],
          labels: [...labels, sale.sellerName],
        };
      },
      { series: [], labels: [] }
    );
  });

  //const mockData = {
  //    series: [477138, 499928, 444867, 220426, 473088],
  //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  //}

  const options = {
    legend: {
      show: true,
    },
  };

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="240"
    />
  );
}
