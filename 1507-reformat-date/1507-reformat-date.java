class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        
        String dayStr = parts[0];
        String monthStr = parts[1];
        String year = parts[2];
        
        String[] months = {
            "Jan","Feb","Mar","Apr","May","Jun",
            "Jul","Aug","Sep","Oct","Nov","Dec"
        };
        
        int day = Integer.parseInt(dayStr.substring(0, dayStr.length() - 2));
        String dayFormatted = (day < 10 ? "0" : "") + day;
        
        int monthIndex = 0;
        for (int i = 0; i < 12; i++) {
            if (months[i].equals(monthStr)) {
                monthIndex = i + 1;
                break;
            }
        }
        
        String monthFormatted = (monthIndex < 10 ? "0" : "") + monthIndex;
        
        return year + "-" + monthFormatted + "-" + dayFormatted;
    }
}