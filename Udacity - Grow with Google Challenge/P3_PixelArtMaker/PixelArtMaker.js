
$(function () {
    $("#sizePicker").on("submit", function (event) {
        event.preventDefault();
        $("#pixel_canvas").empty();
        var table = "";
        for (var rows = 0 ; rows <  $("#input_height").val() ; rows++) {
            table += "<tr>";
            for (var columns = 0 ; columns < $("#input_width").val() ; columns++) {
                table += "<td></td>";
            }
            table += "</tr>";
        }
        $("#pixel_canvas").append(table);
    });
    
    $("body").on("click", "td", function () {
        $(this).css("background-color", $("#colorPicker").val());
    });
});
