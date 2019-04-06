import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}
	
	public static List<Integer> partitionLabels(String S) {
		List<Integer> result = new LinkedList<Integer>();
		
		int count = 1;
		int point = 0;
		
		for (; point < S.length(); point++) {
			int end = S.lastIndexOf(S.charAt(point));
			
			for (; point < end; point++) {
				char buf = S.charAt(point);
				end = (end > S.lastIndexOf(buf))? end : S.lastIndexOf(buf);		
				count++;
			}
			result.add(count);
			count = 1;
		}
		
		return result;
    }

}
