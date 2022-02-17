package optionalTask2;

import java.util.*;

//Optional Task 2
public class task {
	public static void main(String[] args) {
		int n;
		int k;
		int maxLength;
		int minLength;
		int[][] matrix;
		System.out.print("Введите n - размерность матрицы a [n][n] и нажмите <Enter>: ");

		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		System.out.print(
				"Введите значение М - для генерации случайных значений в интревале от -M до M и нажмите <Enter>: ");
		maxLength = scan.nextInt();
		minLength = -maxLength;
		System.out.print(
				"Введите значение k - для порядочивания строк (столбцов) матрицы в порядке возрастания значений элементов k-го столбца (строки) и нажмите <Enter>: ");
		k = scan.nextInt();
		scan.close();

		matrix = new int[n][n];

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = getRandomNumber(minLength, maxLength);
			}
		}

		System.out.println("Начальная матрица");
		printMatrix(matrix);

		System.out.println("-------");
		System.out.println("Пункт 1");
		System.out.println(
				"Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки)");
		sortMatrix(matrix, k);// 1
		printMatrix(matrix);

		//System.out.println("-------");
		//System.out.println("Пункт 2"); // TODO: 2/16/22 доработать алгоритм
		//System.out
		//		.println("Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.");
		// printFoo2(matrix);//2

		System.out.println("-------");
		System.out.println("Пункт 3");
		System.out.println(
				"Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки");
		printSumBetweenFirstAndSecondPositiveNumbers(matrix);// 3

		System.out.println("-------");
		System.out.println("Пункт 4");
		System.out.println(
				"Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие");
		//printMatrixWhereRowAndColWithMaxElementAreDeletedOnlyFirstOne(matrix);// 4.2
		printMatrixWhereRowAndColWithMaxElementAreDeleted(matrix);// 4.1
	}

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public static int getRandomNumberUsingNextInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	// 1
	public static void sortMatrix(int[][] matrix, int k) {
		// k - значение колонки или ряда
		// сортировка рядов по значению в колонке
		boolean sortable = true;

		while (sortable) {
			sortable = false;

			for (int i = 1; i < matrix.length; i++) {
				if (matrix[i][k] < matrix[i - 1][k]) {
					sortable = true;

					int[] tmp = matrix[i];
					matrix[i] = matrix[i - 1];
					matrix[i - 1] = tmp;
				}
			}
		}

		matrix.clone();
		// printMatrix(matrix);
		// сортировка колонок по значению в ряде
		sortable = true;

		while (sortable) {

			sortable = false;

			for (int i = 0; i < matrix.length - 1; i++) {
				if (matrix[k][i] > matrix[k][i + 1]) {
					for (int j = 0; j < matrix.length; j++) {
						sortable = true;

						int tmp = matrix[j][i];
						matrix[j][i] = matrix[j][i + 1];
						matrix[j][i + 1] = tmp;
					}
				}
			}
		}
		printMatrix(matrix);
	}


	// 3
	public static void printSumBetweenFirstAndSecondPositiveNumbers(int[][] matrix) {
		int firstId = 0;
		int firstElem = 0;
		int secondId = 0;
		int secondElem = 0;
		// boolean foundFirstElement = false;
		int Sum = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] > 0) {
					if (firstElem == 0) {
						firstId = col;
						firstElem = matrix[row][col];
					}
					else if (secondElem == 0) {
						secondId = col;
						secondElem = matrix[row][col];
					}
					else {
						break;
					}
				}
				// System.out.printf("%4d", matrix[row][col]);
			}
			if (firstElem != 0 && secondElem != 0) {
				for (int i = firstId + 1; i < secondId; i++) {
					Sum += matrix[row][i];
				}
				System.out.println("Сумма ряда " + row + " = " + Sum);
			}
			else {
				System.out.println("В ряде " + row + " не хватает положительных значений");
			}

			firstId = 0;
			secondId = 0;
			firstElem = 0;
			secondElem = 0;
			Sum = 0;
		}
	}

	// 4.1
	public static void printMatrixWhereRowAndColWithMaxElementAreDeleted(int[][] matrix) {
		List<int[]> maxElementCoordinates = getMaxElementsCoordinates(matrix);
		Map<String, List> linesFromMaxElemCoords = getLinesFromMaxElemCoords(maxElementCoordinates);
		int[][] newArray = deleteLinesWithMaxElements(linesFromMaxElemCoords, matrix);
		printMatrix(newArray);
	}

	//4.1.1
	public static List<int[]> getMaxElementsCoordinates(int[][] mtrx) {
		int maxValue = Integer.MIN_VALUE;// присвоить начальное минимальное значение

		List<int[]> maxElemCoords = new ArrayList<int[]>();// список координат максимальных элементов

		// поиск максимального значения и координат в матрице
		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[i].length; j++) {
				if (maxValue < mtrx[i][j]) {
					maxValue = mtrx[i][j];
					maxElemCoords.clear();
					maxElemCoords.add(new int[] { i, j });
				}
				else if (maxValue == mtrx[i][j]) {
					maxElemCoords.add(new int[] { i, j });
				}
			}
		}
		System.out.println("Максимальное значение элемента в матрице: " + maxValue);
		System.out.println("Количество максимальных элементов: " + maxElemCoords.size());
		return maxElemCoords;
	}

	//4.1.2
	public static Map<String, List> getLinesFromMaxElemCoords(List<int[]> maxElemCoords) {
		List rows = new ArrayList(); // список неповторяющихся рядов максимальных элементов
		List columns = new ArrayList();// список неповторяющихся столбцов максимальных элементов
		for (int[] coordinates : maxElemCoords) {
			int row = coordinates[0];
			int column = coordinates[1];

			if (!rows.contains(row)) {//если список не сожержит такого элемента, то добавить его в список
				rows.add(row);
			}
			if (!columns.contains(column)) {
				columns.add(column);
			}
		}
		Map<String, List> linesToDelete = new HashMap<String, List>();// словарь для рядов и колонок
		linesToDelete.put("rows", rows);
		linesToDelete.put("columns", columns);
		return linesToDelete;
	}

	//4.1.3
	public static int[][] deleteLinesWithMaxElements(Map<String, List> linesFromMaxElemCoordinates, int[][] mtrx) {
		List rows = linesFromMaxElemCoordinates.get("rows");
		List columns = linesFromMaxElemCoordinates.get("columns");
		int[][] arrayWithoutMaxElements = new int[mtrx.length - rows.size()][mtrx.length - columns.size()];
		int rowIndex = 0;
		for (int row = 0; row < mtrx.length; row++) {
			if (!rows.contains(row)) {
				int colIndex = 0;
				for (int col = 0; col < mtrx[row].length; col++) {
					if (!columns.contains(col)) {
						arrayWithoutMaxElements[rowIndex][colIndex++] = mtrx[row][col];
					}
				}
				rowIndex++;
			}
		}
		return arrayWithoutMaxElements;
	}

	// 4.2
	public static void printMatrixWhereRowAndColWithMaxElementAreDeletedOnlyFirstOne(int[][] matrix) {
		int max = 0;
		int row = 0;
		int col = 0;
		int new_row = 0;
		int new_col = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (max < matrix[i][j]) {
					max = matrix[i][j];
					row = i;
					col = j;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (i != row) {

				for (int j = 0; j < matrix[i].length; j++) {
					if (j != col) {

						System.out.print(matrix[i][j] + " ");
						new_col++;
					}

				}
				new_col = 0;
				new_row++;
				System.out.println();
			}
		}
		// printMatrix(newArray);
	}

	//вывести матрицу на экран
	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.printf("%4d", matrix[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
