class Solution:
    def mincostToHireWorkers(
        self, quality: List[int], wage: List[int], k: int
    ) -> float:
        res = float("inf")

        pairs = []  # (ratio, quality)
        for i in range(len(quality)):
            pairs.append((wage[i] / quality[i], quality[i]))
        pairs.sort(key=lambda p: p[0])

        maxheap = []  # Quality
        total_quality = 0
        for ratio, q in pairs:
            heapq.heappush(
                maxheap, -q
            )  # we adding it negative to make the heap act as max heap
            total_quality += q

            if len(maxheap) > k:
                n = heapq.heappop(maxheap)
                total_quality += n  # we are acually removing it because it is negative

            if len(maxheap) == k:
                res = min(res, total_quality * ratio)

        return res
