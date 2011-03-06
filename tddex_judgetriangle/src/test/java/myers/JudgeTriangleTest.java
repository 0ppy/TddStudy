package myers;

import junit.framework.Assert;

import org.junit.Test;


public class JudgeTriangleTest {
	@Test
	public void 正三角形が正しく判定されること(){
		Assert.assertEquals(Result.正三角形, JudgeTriangle.judgeTriangle(1,1,1));
	}

	/* 二等辺三角形の値の組み合わせ
	 * 
	 *   　#1  #2  #3
	 *  a　 1　 2　 2
	 *  b　 2　 1　 2
	 *  c　 2　 2　 1  	 
	 */
	@Test
	public void 二等辺三角形が正しく判定されるかこと(){
		Assert.assertEquals(Result.二等辺三角形, JudgeTriangle.judgeTriangle(1,2,2));
		Assert.assertEquals(Result.二等辺三角形, JudgeTriangle.judgeTriangle(2,1,2));
		Assert.assertEquals(Result.二等辺三角形, JudgeTriangle.judgeTriangle(2,2,1));
	}

	/* 不等辺三角形の値の組み合わせ
	 * 
	 *   　#1  #2  #3
	 *  a　 2　 4　 3　
	 *  b　 3　 2　 4 
	 *  c　 4　 3　 2　  	 
	 */
	@Test
	public void 不等辺三角形が正しく判定されること(){
		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(2,3,4));
		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(4,2,3));
		Assert.assertEquals(Result.不等辺三角形, JudgeTriangle.judgeTriangle(3,4,2));
	}

	/* 三角不等式の値の組み合わせ
	 * 1辺がほかの2辺の合計と同値
	 *   　#1  #2  #3
	 *  a　 1　 3　 2　
	 *  b　 2　 1　 3
	 *  c　 3　 2　 1  	 
	 *
	 * 1辺がほかの2辺の合計よりも大きい
	 *   　#4  #5  #6
	 *  a　 1　 4　 2　
	 *  b　 2　 1　 4 
	 *  c　 4　 2　 1　  	 
	 */
	@Test
	public void 三角形の３つの辺が三角不等式を満たさない場合は三角形ではないと判定すること(){
		// 1辺がほかの２辺の合計と同値 #1,#4,#5
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1,2,3));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(3,1,2));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(2,3,1));
		// 1辺がほかの２辺の合計より大きい
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1,2,4));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(4,1,2));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(2,4,1));
	}

	/* 1辺以上の辺に0の値が含まれる
	 * 
	 *   　#1  #2  #3  #4
	 *  a　 0　 1　 1　  0
	 *  b　 1　 0　 1 　 0
	 *  c　 1　 1　 0　  0 
	 */
	@Test
	public void 三角形の辺に0が含まれた場合は三角形ではないと判定すること(){
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(0,1,1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1,0,1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1,1,0));
		// オール0のチェック
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(0,0,0));
	}

	/* 1辺以上の辺にマイナスの値が含まれる
	 * 
	 *   　#1  #2  #3  #4
	 *  a　-1　 1　 1　 -1
	 *  b　 1　-1　 1　 -1
	 *  c　 1　 1　-1　 -1 
	 */
	@Test
	public void 三角形の辺にマイナス値が含まれた場合は三角形ではないと判定すること(){
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(-1,1,1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1,-1,1));
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(1,1,-1));
		// オールマイナス値のチェック
		Assert.assertEquals(Result.三角形ではない, JudgeTriangle.judgeTriangle(-1,-1,-1));
	}
	
}
