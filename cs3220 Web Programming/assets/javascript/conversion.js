$(function() {
    function convert() {
        let inputNumber = parseFloat($("#inputNumber").val());
        let measure = $("#measure").val();
        let result = 0;

        if (isNaN(inputNumber)) {
            $("#result").text("0");
            return;
        }

        switch (measure) {
            case "cm":
                result = inputNumber * 2.54;
                break;
            case "inch":
                result = inputNumber;
                break;
            case "feet":
                result = inputNumber / 12;
                break;
            case "yard":
                result = inputNumber / 36;
                break;
            case "meter":
                result = inputNumber * 0.0254;
                break;
            default:
                $("#result").text("0");
                return;
        }

        $("#result").text(result.toFixed(2));
    }

    $("#inputNumber").on("input", convert);
    $("#measure").change(convert);
});