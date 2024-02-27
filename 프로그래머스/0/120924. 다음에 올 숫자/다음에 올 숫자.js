function solution(common) {
    return common.at(-1) - common.at(-2) == common.at(-2) - common.at(-3) 
        ? common.at(-1) + common.at(-1) - common.at(-2) 
        : common.at(-1) * (common.at(-1) / common.at(-2));
}