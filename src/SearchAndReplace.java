import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchAndReplace {
	public static String replace(final String template, final Map<String, String> map) {
		final StringBuilder list = new StringBuilder("(");
		for (final String key : map.keySet()) {
			list.append(key);
			list.append("|");
		}
		list.append("[^\\s\\S])");
		System.out.println(list);
		Pattern pattern = Pattern.compile(list.toString());
		Matcher matcher = pattern.matcher(template);
		final StringBuffer stringBuffer = new StringBuffer();
		while (matcher.find()) {
			final String string = matcher.group(1);
			matcher.appendReplacement(stringBuffer, map.get(string));
		}
		matcher.appendTail(stringBuffer);
		return stringBuffer.toString();
	}

	public static void main(final String[] args) {
		final Map<String, String> map = new HashMap<String, String>();
		map.put("&apos;","'");
		System.out.println(replace("of whether Abell&apos;s", map));
	}
}