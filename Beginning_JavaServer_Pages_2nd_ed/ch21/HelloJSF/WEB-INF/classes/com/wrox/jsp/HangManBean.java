package com.wrox.jsp;
public class HangManBean
{
    private String guesses;
    private String guess;
    private String misses;
    
    public HangManBean()
    {
    }
    
    public String getGuess()
    {
        return guess;
    }
    
    public void setGuess(String guess)
    {
        this.guess = guess;
    }
    
    public String getGuesses()
    {
        return guesses;
    }
    
    public void setGuesses(String guesses)
    {
        this.guesses = guesses;
    }
    
    public String getMisses()
    {
        return misses;
    }
    
    public void setMisses(String misses)
    {
        this.misses = misses;
    }
}
