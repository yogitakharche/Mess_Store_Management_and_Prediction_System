const ctx = document.getElementById('productChart').getContext('2d');
        let chart;

        function showRequirements() {
            const productSelect = document.getElementById('productSelect');
            const productName = productSelect.value;

            if (productName === '') {
                alert('Please select a product');
                return;
            }

            const currentYear = new Date().getFullYear();
            const years = [currentYear + 1, currentYear + 2, currentYear + 3];

            let resultDiv = document.getElementById('result');
            resultDiv.innerHTML = `<h3>Requirements for ${productName}:</h3>`;

            let productData = [];

            years.forEach(year => {
                const requiredAmount = Math.floor(Math.random() * 500) + 1;
                productData.push(requiredAmount);

                const yearCard = `
                    <div class="year-card">
                        <span class="year">${year}</span>
                        <span class="units">${requiredAmount} kg</span>
                    </div>
                `;
                resultDiv.innerHTML += yearCard;
            });

            updateChart(productName, years, productData);
        }

        function updateChart(productName, labels, data) {
            if (chart) {
                chart.destroy();
            }

            chart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: `Yearly Requirement for ${productName}`,
                        data: data,
                        backgroundColor: 'lightgrey',
                        borderColor: 'grey',
                        borderWidth: 2,
                        borderRadius: 10,
                        barThickness: 30 // Set the thickness of the bars (adjust as needed)
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: 'Units (kg)',
                                color: 'black'
                            },
                            ticks: {
                                color: 'black'
                            }
                        },
                        x: {
                            ticks: {
                                color: 'black'
                            }
                        }
                    },
                    responsive: true,
                    maintainAspectRatio: false
                }
            });
        }