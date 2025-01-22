class Solution {
    public int bestClosingTime(String cust) {
        int totalSatisfied = 0;

        
        for (int i = 0; i < cust.length(); i++) {
            if (cust.charAt(i) == 'Y') {
                totalSatisfied++;
            }
        }

        int pen = totalSatisfied; 
        int minPen = pen;
        int bestTime = 0;

  
        for (int i = 0; i < cust.length(); i++) {
            if (cust.charAt(i) == 'Y') {
                pen--; 
            } else {
                pen++; 
            }

      
            if (pen < minPen) {
                minPen = pen;
                bestTime = i + 1;
            }
        }

        return bestTime;
    }
}
