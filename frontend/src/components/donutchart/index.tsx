import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

type ChartData = {
  series: number[];
  labels: string[];
};

export default function DonutChart() {
  const [chartData, setChartData] = useState<ChartData>({
    series: [],
    labels: [],
  });

  useEffect(() => {
    (async () => {
      const response = await axios.get(`${BASE_URL}/sales/ammount-by-seller`);
      const data = response.data as SaleSum[];
      const chartData = data.reduce<ChartData>(
        (chartData, sale) => {
          const { series, labels } = chartData;
          return {
            series: [...series, sale.sum],
            labels: [...labels, sale.sellerName],
          };
        },
        { series: [], labels: [] }
      );
      setChartData(chartData);
    })();
  }, []);

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
