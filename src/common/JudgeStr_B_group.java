package common;

public class JudgeStr_B_group {
	/*---  Field  ---*/
	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/**
	 * インスタンス作成不可
	 */
	private JudgeStr_B_group() {
	}

	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	/**
	 * 文字列がnullのとき、空文字に変換する
	 * @param
	 * 		str 文字列
	 * @return
	 * 		nullの場合、空文字　nullではない場合、文字列
	 */
	public static String resetNull(String str) {
		if(str == null) {
			return "";
		}
		return str;
	}

	/**
	 * 文字列が使用可能(null、空文字ではない)かどうか判断
	 * @param
	 * 		str 判断する文字列
	 * @return
	 * 		文字列が使用可能かどうかの判断結果
	 */
	public static Boolean isUseStr(String str) {
		if(str == null || str.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * 文字列が数字かどうか判断
	 * @param
	 * 		num 判断する文字列
	 * @return
	 * 		文字列がすべて数字かどうかの判断結果
	 */
	public static Boolean isNumber(String num) {
		char[] spWord;

		if(isUseStr(num) == false) {
			return false;
		}

		spWord = num.toCharArray();

		for(char word : spWord) {
			if(Character.isDigit(word) == false) {
				return false;
			}
		}
		return true;
	}

	/*---  Method End  ---*/
}
