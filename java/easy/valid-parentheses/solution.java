class Solution {
    public boolean isValid(String s) {
        Map<String, String> map = new HashMap();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");

        Stack<String> stack = new Stack();
        String letter = "";
        for(int i = 0; i < s.length(); i++) {
            letter = String.valueOf(s.charAt(i));

            if (letter.equals("(") || letter.equals("{") || letter.equals("[")) {
                stack.push(letter);
            }
            if (letter.equals(")") || letter.equals("}") || letter.equals("]")) {
                if (stack.size() == 0) {
                    return false;
                }
                String pop = stack.pop();
                if (!map.get(letter).equals(pop)) {
                    return false;
                }
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}