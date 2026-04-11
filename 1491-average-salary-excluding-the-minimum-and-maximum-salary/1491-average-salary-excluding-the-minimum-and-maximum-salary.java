class Solution {
    public double average(int[] salary) {

        int n = salary.length;
        double maxSalary = Double.MIN_VALUE;
        double minSalary = Double.MAX_VALUE;
        double sum = 0;

        for(int i = 0; i < n; i++){
            if(salary[i] > maxSalary){
                maxSalary = salary[i];
            }
            if(salary[i] < minSalary){
                minSalary = salary[i];
            }
            sum += salary[i];
        }
        return (sum - minSalary - maxSalary)/(n-2); 
    }
}