
function formatInputAmount(amount) {
    var parts = amount.split('.');
    let whole = (parseInt(amount) || 0).toLocaleString('en-US');
    if (parts.length == 1) {
        return whole;
    } else {
        return whole + '.' + parts[1].substring(0,2);
    }
}