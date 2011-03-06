package myers;

public class JudgeTriangle {

	public static Result judgeTriangle(int sideA, int sideB, int sideC) {
		if(isNotTriangle(sideA, sideB, sideC)) return Result.三角形ではない;
		if (isRegularTriangle(sideA, sideB, sideC)) return  Result.正三角形;
		if (isIsoscelesTriangle(sideA, sideB, sideC)) return  Result.二等辺三角形;
		return (isInequilateralTriangle(sideA, sideB, sideC)) ?  Result.不等辺三角形 : Result.三角形ではない;
	}

	private static boolean isNotTriangle(int sideA, int sideB, int sideC) {
		return sideA >= (sideB + sideC) || sideB >= (sideA + sideC) || sideC >= (sideA + sideB);
	}

	private static boolean isRegularTriangle(int sideA, int sideB, int sideC) {
		return sideA == sideB && sideB == sideC;
	}

	private static boolean isIsoscelesTriangle(int sideA, int sideB, int sideC) {
		return sideA == sideB || sideB == sideC || sideA == sideC;
	}

	private static boolean isInequilateralTriangle(int sideA, int sideB, int sideC) {
		return sideA != sideB && sideB != sideC && sideA != sideC;
	}
}
