function solution(myString, pat) {
    return myString.slice(0, myString.lastIndexOf(pat) + 1 + pat.length-1);
}