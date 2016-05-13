package com.interview.intterviewbit.string;

import java.util.ArrayList;
import java.util.List;

public class PettyJason
{
	public List<String> json(String a)
	{
		ArrayList<String> result = new ArrayList<String>();

		int tabCount = 0, beg = 0, end = a.length() - 1;

		StringBuilder sb = new StringBuilder();
		while (beg <= end)
		{
			char ch = a.charAt(beg);
			switch (ch)
			{
			case '[':
			case '{':
				String str = sb.toString().trim();
				if(!str.equals("")){
					result.add(str);
					sb = getTabs(tabCount);
				}
				sb.append(ch);
				result.add(sb.toString());
				tabCount++;
				sb = getTabs(tabCount);
				break;
			case ']':
			case '}':
				tabCount--;
				result.add(sb.toString());
				sb = getTabs(tabCount);
				sb.append(ch);
				break;
			case ',':
			    sb.append(ch);
			    result.add(sb.toString());
				sb = getTabs(tabCount);
				break;
			default:
				sb.append(ch);
			}

			beg++;
		}
        
        result.add(sb.toString());
		return result;
	}

	private StringBuilder getTabs(int tabCount)
	{
		StringBuilder sb = new StringBuilder();
		while (tabCount > 0)
		{
			sb.append("\t");
		}

		return sb;
	}
}
