/*
 *  Kenneth Hanner
 *  ITDEV-110-500
 *  FINAL EXAM
 */
package hanner_finalexam;

import javax.sound.sampled.*;

public class SoundUtils 
{
  public static float SAMPLE_RATE = 8000f;

  public static void tone(int hz, int msecs) throws LineUnavailableException 
  {
     tone(hz, msecs, 1.0);//tone array
  }

  public static void tone(int hz, int msecs, double vol)throws LineUnavailableException 
  {
    byte[] buf = new byte[1];

    AudioFormat af = 
        new AudioFormat(
            SAMPLE_RATE, // sampleRate
            8,           // sampleSizeInBits
            1,           // channels
            true,        // signed
            false);      // bigEndian
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();

    for (int i=0; i < msecs*8; i++)
    {
      double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
      buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
      sdl.write(buf,0,1);
    }
    sdl.drain();
    sdl.stop();
    sdl.close();


  }
  
    public void alert() throws LineUnavailableException
    {
        SoundUtils.tone(392,100);//plays root G
    }

    public void error() throws LineUnavailableException
    {
        SoundUtils.tone(104,30);//plays G#
        SoundUtils.tone(104,50);//plays G#
    }

    public void low() throws LineUnavailableException
    {
        SoundUtils.tone(392,50);//plays root G
        SoundUtils.tone(175,150);//plays dom7 F
    }

    public void high() throws LineUnavailableException
    {
        SoundUtils.tone(392,50);//plays root G
        SoundUtils.tone(566,50);//plays out of tune C#
    }

    public void correct() throws LineUnavailableException
    {
        SoundUtils.tone(392,50);//plays root G
        SoundUtils.tone(494,80);//plays maj3 B
        SoundUtils.tone(587,110);//plays p5   D
        SoundUtils.tone(784,180);//plays root G octave
    }

      public void beep() throws LineUnavailableException
    {
        SoundUtils.tone(392,50);//plays root G
    }

      public void flea() throws LineUnavailableException
    {
        SoundUtils.tone(330,100);//eighth note E
        SoundUtils.tone(349,100);//eighth note F 
        SoundUtils.tone(370,100);//eighth note F#
        SoundUtils.tone(392,200);//quartr note G
        SoundUtils.tone(659,200);//quartr note E
        SoundUtils.tone(659,100);//eighth note E
        SoundUtils.tone(587,200);//quartr note D
        SoundUtils.tone(554,500);//long note C#      
        SoundUtils.tone(440,100);//eighth note A
        SoundUtils.tone(415,100);//eighth note Ab
        SoundUtils.tone(392,100);//eighth note G
        SoundUtils.tone(370,200);//quartr note F#
        SoundUtils.tone(587,200);//quartr note D
        SoundUtils.tone(587,100);//eighth note D
        SoundUtils.tone(523,200);//quartr note C
        SoundUtils.tone(494,500);//long note B
        SoundUtils.tone(392,100);//eighth note G                
        SoundUtils.tone(370,100);//eighth note F#
        SoundUtils.tone(349,100);//eighth note F           
        SoundUtils.tone(330,100);//eighth note E          
        SoundUtils.tone(392,100);//eighth note G
        SoundUtils.tone(523,100);//eighth note C           
        SoundUtils.tone(440,200);//quartr note A
        SoundUtils.tone(523,100);//eighth note C                 
        SoundUtils.tone(587,200);//quartr note D
        SoundUtils.tone(392,100);//eighth note G                    
        SoundUtils.tone(466,100);//eighth note Bb                    
        SoundUtils.tone(622,100);//eighth note Eb                   
        SoundUtils.tone(523,200);//quartr tone C                   
        SoundUtils.tone(622,100);//eighth note Eb
        SoundUtils.tone(698,200);//quartr note F                  
        SoundUtils.tone(784,1000);//vlong note G
        SoundUtils.tone(784,100);//eighth note G
        SoundUtils.tone(784,100);//eighth note G
        SoundUtils.tone(880,100);//eighth note A
        SoundUtils.tone(784,100);//eighth note G                      
        SoundUtils.tone(622,50);//sixtnth note Eb
        SoundUtils.tone(587,150);//dtdeth note E
        SoundUtils.tone(523,500);//long note C
    }
}