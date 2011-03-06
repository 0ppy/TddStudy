package myers;

import myers.JudgeTriangle;
import myers.Result;

import org.junit.Assert;
import org.junit.Test;


public class JudgeTriangleTest {
	@Test
	public void 正三角形を正しく判定すること(){
		Assert.assertEquals(Result.正三角形, JudgeTriangle.judgeTriangle(1,1,1));
	}
	
	@Test
	public void 二等辺三角形を正しく判定すること(){
		Assert.assertEquals(Result.二等辺三角形, JudgeTriangle.judgeTriangle(2,2,1));
		Assert.assertEquals(Result.二等辺三角形, JudgeTriangle.judgeTriangle(2,1,2));
		Assert.assertEquals(Result.二等辺三角形, JudgeTriangle.judgeTriangle(1,2,2));
	}
	
	@Test
	public void 不等辺三角形を正しく判定すること(){
 		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(2,3,4));
 		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(3,2,4));
 		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(4,3,2));
 		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(4,2,3));
 		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(2,4,3));
 		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(3,4,2));
	}
	
	@Test
	public void 三角形の3辺の数値が三角形の条件を満たさない場合は三角形でないと判定すること(){
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(0, 1, 1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1, 0, 1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1, 1, 0));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(3, 1, 1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1, 3, 1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1, 1, 3));
	}

}
