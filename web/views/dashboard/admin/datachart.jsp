<!--begin::Income Chart-->
<script>
    // Class definition
    var IncomeChart = function () {
        var chart = {
            self: null,
            rendered: false
        };

        // Private methods
        var initChart = function (chart) {
            var element = document.getElementById("admin_income_chart");

            if (!element) {
                return;
            }

            var height = parseInt(KTUtil.css(element, 'height'));
            var labelColor = KTUtil.getCssVariableValue('--kt-gray-500');
            var borderColor = KTUtil.getCssVariableValue('--kt-border-dashed-color');
            var baseColor = KTUtil.getCssVariableValue('--bs-cyan');
            var lightColor = KTUtil.getCssVariableValue('--bs-cyan');

            var options = {
                series: [{
                        name: 'Sales',
                        data: [0,
                            <c:forEach var="date" items="${requestScope.setIncome}">
                                ${((mapIncome.get(date)*5)/100)/1000000},
                            </c:forEach>
                        0]
                    }],
                chart: {
                    fontFamily: 'inherit',
                    type: 'area',
                    height: height,
                    toolbar: {
                        show: false
                    }
                },
                plotOptions: {

                },
                legend: {
                    show: false
                },
                dataLabels: {
                    enabled: false
                },
                fill: {
                    type: "gradient",
                    gradient: {
                        shadeIntensity: 1,
                        opacityFrom: 0.4,
                        opacityTo: 0,
                        stops: [0, 80, 100]
                    }
                },
                stroke: {
                    curve: 'smooth',
                    show: true,
                    width: 3,
                    colors: [baseColor]
                },
                xaxis: {
                    categories: ['',
                        <c:forEach var="incomeDaily" items="${requestScope.setIncome}">
                            '${incomeDaily}',
                        </c:forEach>
                        ''
                    ],
                    axisBorder: {
                        show: false,
                    },
                    axisTicks: {
                        show: false
                    },
                    tickAmount: 6,
                    labels: {
                        rotate: 0,
                        rotateAlways: true,
                        style: {
                            colors: labelColor,
                            fontSize: '12px'
                        }
                    },
                    crosshairs: {
                        position: 'front',
                        stroke: {
                            color: baseColor,
                            width: 1,
                            dashArray: 3
                        }
                    },
                    tooltip: {
                        enabled: true,
                        formatter: undefined,
                        offsetY: 0,
                        style: {
                            fontSize: '12px'
                        }
                    }
                },
                yaxis: {
                    tickAmount: 4,
                    max: 10,
                    min: 0,
                    labels: {
                        style: {
                            colors: labelColor,
                            fontSize: '12px'
                        },
                        formatter: function (val) {
                            return 'đ' + val + "M"
                        }
                    }
                },
                states: {
                    normal: {
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    },
                    hover: {
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    },
                    active: {
                        allowMultipleDataPointsSelection: false,
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    }
                },
                tooltip: {
                    style: {
                        fontSize: '12px'
                    },
                    y: {
                        formatter: function (val) {
                            return "đ" + val + "M"
                        }
                    }
                },
                colors: [lightColor],
                grid: {
                    borderColor: borderColor,
                    strokeDashArray: 4,
                    yaxis: {
                        lines: {
                            show: true
                        }
                    }
                },
                markers: {
                    strokeColor: baseColor,
                    strokeWidth: 3
                }
            };

            chart.self = new ApexCharts(element, options);

            // Set timeout to properly get the parent elements width
            setTimeout(function () {
                chart.self.render();
                chart.rendered = true;
            }, 200);
        }

        // Public methods
        return {
            init: function () {
                initChart(chart);

                // Update chart on theme mode change
                KTThemeMode.on("kt.thememode.change", function () {
                    if (chart.rendered) {
                        chart.self.destroy();
                    }

                    initChart(chart);
                });
            }
        }
    }();

// Webpack support
    if (typeof module !== 'undefined') {
        module.exports = IncomeChart;
    }

// On document ready
    KTUtil.onDOMContentLoaded(function () {
        IncomeChart.init();
    });
</script>
<!--end::IncomeChart-->