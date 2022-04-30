protocol = $(location).attr('protocol') + '//';
hostUrl = $(location).attr('host');
localServerUrl = protocol+hostUrl+'/';

google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

    var init = [
        ['Категория инцидента', 'Кол-во инцидентов']
    ];

    $.ajax({
        url: localServerUrl + "Incidents/info/tour/data",
        contentType: "application/json",
        method: "GET",
        success: function (result) {
            console.log(result);
            init = init.concat(func(result));
            console.log(init);
            draw(init);
        },
        dataType: "json"
    });

}

func = (result) => {
    return result.map(elem => {
        return [elem.tripName, elem.countTrip]
    })
};

draw = (init)=>{
    var data = google.visualization.arrayToDataTable(init);

    var options = {
        title: 'Статистика популярности существующих инцидентов',
        chartArea: {width: '70%'},
        hAxis: {
            title: 'Количество инцидентов',
            minValue: 0
        },
        vAxis: {
            title: 'И Н Ц И Д Е Н Т'
        }
    };

    var tour = new google.visualization.BarTour(document.getElementById('tour_div'));


    tour.draw(data, options);
};