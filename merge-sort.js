console.log(merge_sort([9, 2, 4, 1, 2, 4, 7, -19]));
console.log(merge_sort(["g", "a", "h", "k", "A", 1223]));

function merge(left, right) {
    var result = [];
    var il = 0;
    var ir = 0;
    while (il < left.length && ir < right.length) {
        if (left[il] < right[ir]) {
            result.push(left[il++]);
        } else {
            result.push(right[ir++]);
        }
    }

    while (il < left.length) {
        result.push(left[il++]);
    }

    while (ir < right.length) {
        result.push(right[ir++]);
    }
    return result;
}

function merge_sort(array) {
    var length = array.length;
    if (length == 1) {
        return array;
    }

    var mid = Math.floor(length / 2);
    var left = array.slice(0, mid);
    var right = array.slice(mid, length);

    return merge(merge_sort(left), merge_sort(right));

}