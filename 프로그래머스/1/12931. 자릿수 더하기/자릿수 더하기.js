function solution(n)
{
    return [...`${n}`].reduce((acc, el) => acc + +el, 0);
}