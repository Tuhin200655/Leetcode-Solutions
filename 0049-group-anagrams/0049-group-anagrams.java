import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        return new AbstractList<List<String>>() {
            private List<List<String>> result;
            @Override
            public List<String> get(int index) {
                if (result == null) init();
                return result.get(index);
            }
            @Override
            public int size() {
                if (result == null) init();
                return result.size();
            }

            private void init() {
                result = Arrays.stream(strs)
                    .collect(Collectors.groupingBy(s -> {
                        var k = s.toCharArray();
                        Arrays.sort(k);
                        return new String(k);
                    }))
                    .values().stream().toList();
            }
        };
    }
}