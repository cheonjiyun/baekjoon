function solution(a, b, g, s, w, t) {
    const n = g.length;

    function isPossible(mid) {
        let totalGold = 0;
        let totalSilver = 0;
        let totalAll = 0;

        for (let i = 0; i < n; i++) {
            let trips = Math.floor(mid / (2 * t[i]));
            if (mid % (2 * t[i]) >= t[i]) {
                trips += 1;
            }

            let maxWeight = trips * w[i];
            let gold = Math.min(g[i], maxWeight);
            let silver = Math.min(s[i], maxWeight);
            let total = Math.min(g[i] + s[i], maxWeight);

            totalGold += gold;
            totalSilver += silver;
            totalAll += total;
        }

        return totalGold >= a && totalSilver >= b && totalAll >= a + b;
    }

    let left = 0;
    let right = 1e15;
    let answer = right;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (isPossible(mid)) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return answer;
}
