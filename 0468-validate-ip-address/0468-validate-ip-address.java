class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) { 
            String[] parts = queryIP.split("\\.", -1);
            if (parts.length == 4) {
                for (String p : parts) {
                    if (!isValidIPv4Part(p)) return "Neither";
                }
                return "IPv4";
            }
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) { 
            String[] parts = queryIP.split(":", -1);
            if (parts.length == 8) {
                for (String p : parts) {
                    if (!isValidIPv6Part(p)) return "Neither";
                }
                return "IPv6";
            }
        }
        return "Neither";
    }

    private boolean isValidIPv4Part(String p) {
        if (p.isEmpty() || (p.length() > 1 && p.charAt(0) == '0')) return false;
        try {
            int num = Integer.parseInt(p);
            return num >= 0 && num <= 255 && String.valueOf(num).equals(p);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidIPv6Part(String p) {
        if (p.length() < 1 || p.length() > 4) return false;
        for (char c : p.toCharArray()) {
            if (!Character.toString(c).matches("[0-9a-fA-F]")) return false;
        }
        return true;
    }
}
