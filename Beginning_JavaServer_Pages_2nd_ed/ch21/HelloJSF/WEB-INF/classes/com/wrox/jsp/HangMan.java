package com.wrox.jsp;

import java.util.Arrays;

public class HangMan
{
    public static final int GOOD_GUESS = 0;
    public static final int BAD_GUESS = 1;
    public static final int ALREADY_GUESSED = 2;
    public static final int GAME_OVER = 3;
    
    private boolean gameOver = false;
    private boolean gameWon = false;
    
    private String word = null;
    private StringBuffer matches = new StringBuffer();
    private StringBuffer misses = new StringBuffer();
    private StringBuffer guesses = new StringBuffer();
    private StringBuffer guessedWord = null;
    
    public HangMan()
    {
    }
    
    public HangMan( String s )
    {
        this.word = s.toUpperCase();
    }
    
    public String getGuesses()
    {
        char[] sorted = guesses.toString().toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }
    
    public String getMisses()
    {
        return misses.toString();
    }
    
    public int getMissCount()
    {
        return misses.length();
    }
    
    public String getMatches()
    {
        return matches.toString();
    }
    
    public String getGuessedWord()
    {
        if( guessedWord == null )
        {
            testGameOver();
        }
        return guessedWord.toString();
    }
    
    
    public String getWord()
    {
        if( !gameOver )
            gameOver = true;
        return word;
    }
    
    public int guess( String s )
    {
        if( isGameOver() )
        {
            return GAME_OVER;
        }
        
        int rval = ALREADY_GUESSED;
        s = s.toUpperCase();
        
        //== if the string is more than 1 character, use the last character
        if( s.length() > 1 )
        {
            s = s.substring(s.length()-1);
        }
        //== test for already guessed
        if( guesses.indexOf(s) < 0 )
        {
            guesses.append(s);
            if(word.indexOf(s) >= 0 )
            {
                matches.append(s);
                rval = GOOD_GUESS;
            }
            else
            {
                misses.append(s);
                rval = BAD_GUESS;
            }
        }

        if( testGameOver() )
        {
            rval = GAME_OVER;
        }
        
        return rval;
    }
    
    private boolean testGameOver()
    {
        //== for each letter in the word
        //== if the letter was guessed then reveal it
        //== else leave it hidden.
        int missCount = 0;
        guessedWord = new StringBuffer(word.length());
        for(int i = 0; i < word.length();i++)
        {
            String s = word.substring(i, i+1);
            if(matches.indexOf(s)>= 0)
            {
                guessedWord.append(s);
            }
            else
            {
                missCount++;
                guessedWord.append("*");
            }
        }
        if(missCount == 0)
        {
            gameOver = true;
            gameWon = true;
        }
        else if( misses.length() >= 10 )
        {
            gameOver = true;
            gameWon = false;
        }
        return gameOver;
    }
    
    public boolean isGameOver()
    {
        return gameOver;
    }
    
    public boolean isGameWon()
    {
        return gameWon;
    }
    
    public static final void main(String[] args)
    {
        HangMan h = new HangMan( "abracadabra" );
        com.wrox.jsp.Gallows gallows = new com.wrox.jsp.Gallows();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("word:"+h.getGuessedWord());
        for( int i = 0; i < alphabet.length(); i++)
        {
            String guess = alphabet.substring(i,i+1);
            h.guess( guess );
            System.out.println("word:"+h.getGuessedWord());
            System.out.println("guesses so far:"+h.getGuesses()+". misses "+h.getMissCount());
            gallows.setHeight(h.getMissCount());
            String[] hanger = gallows.getGallows();
            for( int j = 0; j < hanger.length;j++)
            {
                System.out.println(hanger[j]);
            }
            if( h.isGameOver() )
            {
                break;
            }
            System.out.println("================");
        }
        if( h.isGameWon())
        {
            System.out.println("We Won");
        }
        else
        {
            System.out.println("We lost with "+h.getMissCount()+" misses." );
            System.out.println(h.getMisses());
        }
    }
}
