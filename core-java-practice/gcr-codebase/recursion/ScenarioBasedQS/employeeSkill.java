import java.util.ArrayList;
import java.util.List;

public class SkillAssignment {

    public static List<List<Integer>> findTeams(int[] skills, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(skills, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinations(int[] skills, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index == skills.length) {
            return;
        }
        
        current.add(skills[index]);
        findCombinations(skills, target - skills[index], index + 1, current, result);
        
        current.remove(current.size() - 1);
        findCombinations(skills, target, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] skills = {2, 3, 5, 7};
        int target = 10;
        
        List<List<Integer>> teams = findTeams(skills, target);
        for (List<Integer> team : teams) {
            System.out.println(team);
        }
    }
}