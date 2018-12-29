package programing_school.Controller;

import programing_school.Model.Solution;
import programing_school.Model.SolutionDao;

import java.util.List;

public class test {

    public static void main(String[] args) {

        List<Solution> solutions = SolutionDao.allSolutions(5);

        for (Solution sol : solutions){
            System.out.println(sol.getDescription());
        }
    }
}
