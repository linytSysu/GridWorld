package Runners;

import java.io.IOException;

import jigsaw.Jigsaw;
import jigsaw.JigsawNode;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RunnerPart3 {
	/**测试脚本-2
	 * 实验任务二：利用启发式搜索，求解随机5*5拼图（24-数码问题）
	 * 注意：运行前要修改节点维数，将JigsawNode类中的dimension改为5
	 * 要求：不修改脚本内容，程序能够运行，且得出预期结果
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// 检查节点维数是否为5
		if(JigsawNode.getDimension() != 5){
			System.out.print("节点维数不正确，请将JigsawNode类的维数dimension改为5");
			return;
		}

	    String filePath = "resultof487.txt";
		PrintWriter pw = new PrintWriter(new FileWriter(filePath, true));
		
		//for (int weight1 = 1; weight1 <= 5; weight1++) {
		//	for (int weight2 = 12; weight2 >= 5; weight2--) {
		        int weight1 = 4;
		        int weight2 = 8;
		        int weight3 = 7;
				pw.println("Test with weight1: "+ weight1 + ", weight2: " + weight2+ ", weight3: " + weight3);
				int success = 0;
				int total = 0;
				for (int i = 0; i < 20; i++) {		
					JigsawNode destNode = new JigsawNode(new int[]{25,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,0});  		
					JigsawNode startNode = Jigsaw.scatter(destNode, 1000);
					//JigsawNode startNode = new JigsawNode(new int[]{19,8,7,9,23,10,3,19,5,4,14,2,20,11,6,15,22,13,16,0,1,21,12,18,24,17});

					Jigsaw jigsaw = new Jigsaw(startNode, destNode);
					// jigsaw.weight1 = weight1;
					// jigsaw.weight2 = weight2;
					// jigsaw.weight3 = weight3;
					jigsaw.ASearch();
					if (jigsaw.isCompleted()) {
						pw.println(i + " successed!" + " Used " + jigsaw.getSearchedNodesNum() + " steps.");
						success++;
						total += jigsaw.getSearchedNodesNum();
					} else {
						pw.println(i + " failed!" + " The startNode is " + jigsaw.getBeginJNode().toString());
					}
		        }
				pw.println("success " + success + " times!");
				pw.println("average use " + total / success);
				pw.println("-----------------------------------------------------------------");
				pw.println("-----------------------------------------------------------------");
		//    }
	    //}
		pw.close();
	}

}
