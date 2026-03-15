package string;

import java.util.*;

/**
 * Bài toán: Group Anagrams (Nhóm các Anagram).
 * <br>
 * Mục tiêu: Nhóm các chuỗi là hoán vị của nhau lại thành từng list.
 * <br>
 * Giải thuật: Hash Map (Bảng băm).
 * <br>
 * Tư duy:
 * - Hai chuỗi là anagram khi chúng có cùng "chữ ký" (signature).
 * - Cách tạo chữ ký:
 *   1. Sắp xếp chuỗi: "eat" -> "aet", "tea" -> "aet". (Time O(K log K)).
 *   2. Đếm số lượng ký tự và tạo chuỗi mã hóa: "a1e1t1...". (Time O(K)).
 * - Dùng Map<String, List<String>>.
 * - Duyệt qua từng chuỗi, tạo key, thêm vào list tương ứng trong map.
 * <br>
 * Độ phức tạp:
 * - Time: O(N * K log K) nếu dùng sort (N là số chuỗi, K là độ dài max).
 * - Space: O(N * K) - Lưu trữ map.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Tạo key bằng cách sắp xếp ký tự
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

