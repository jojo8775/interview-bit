package com.interview.intterviewbit.string;

//TODO: there is a nlogn way to do this.
public class LongestSubStringPalindrom
{
	public int subString(String str){
		if(str.length() < 2){
			return str.length();
		}
		
		int[][] grid = new int[str.length()][str.length()];
		
		for(int i=0; i<grid.length; i++){
			grid[i][i] = 1;
		}
		
		for(int i=0; i<grid.length; i++){
			int k = 0;
			for(int j=i+1; j<grid.length; j++){
				if(str.charAt(k) == str.charAt(j)){
					if((j-1)-(k+1)+1 == grid[k+1][j-1]){
						grid[k][j] = 2 + grid[k+1][j-1];
					}
					else{
						grid[k][j] = Math.max(grid[k+1][j], grid[k][j-1]);
					}
				}
				else{
					grid[k][j] = Math.max(grid[k+1][j], grid[k][j-1]);
				}
				k++;
			}
		}
		
		print(grid);
		
		int i=0, j=0, max = grid[0][str.length()-1];
		while(grid[0][j] < max){
			j++;
		}

		i = j - max + 1;
		
		System.out.println(str.substring(i,j+1));
		
		return grid[0][str.length()-1];
	}
	
	private static void print(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				System.out.print(arr[i][j] + " , ");
			}
			
			System.out.println();
		}
	}
	
	public String longestPalindrome(String a) {
        if(a.isEmpty() || allCharacterSame(a)){
            return a;
        }

        int[][] dp = new int[a.length()][a.length()];
        
        for(int i=0; i<a.length(); i++){
            dp[i][i] = 1;
        }
            
        String result = a.substring(0,1);
        
        for(int i=1; i<dp.length; i++){
            for(int j=0; j+i < dp.length; j++){
                int k = j+i;
                if(a.charAt(j) == a.charAt(k)){
                    if((k-1) - (j+1) + 1 == dp[j+1][k-1]){
                        dp[j][k] = 2 + dp[j+1][k-1];
                        if(result.length() < i + 1){
                            result = a.substring(j, k+1);
                        }
                    }
                    else{
                        dp[j][k] = Math.max(dp[j+1][k], dp[j][k-1]);
                    }
                }
                else{
                    dp[j][k] = Math.max(dp[j+1][k], dp[j][k-1]);
                }
            }
        }
        
        return result;
    }
    
    private boolean allCharacterSame(String str){
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1) != str.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
	
	public static void main(String[] args){
//		int r = new LongestSubStringPalindrom().subString("geeksskeeg");
//		int r = new LongestSubStringPalindrom().subString("abb");
//		int r = new LongestSubStringPalindrom().subString("abacdfgdcaba");
//		System.out.println(r);
		System.out.println(new LongestSubStringPalindrom().longestPalindrome("abacdfgdcaba"));
	    
	    
	    System.out.println(new LongestSubStringPalindrom().longestPalindrome("abb"));
	}
}
