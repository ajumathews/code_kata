package org.grace.practice.html.parsing.basic;


import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupTest {

    public static void main(String[] args) {
        String text="During <b>nitrous</b> <b>oxide</b> was <b>nitrous</b> <b>oxide</b>" ;
        //String text="During a 20-month period, <b>nitrous</b> <b>oxide</b> was used for analgesia during 146 vascular or interventional procedures. The <b>nitrous</b> <b>oxide</b> was administered by a radiology nurse, who monitored vital signs and patient responses. <b>Nitrous</b> <b>oxide</b> was used without premedication for 27 procedures. 6 Patients required supplemental medication administered intravenously. It was used with premedication for 119 procedures. Supplemental medication was required in 46. Average doses of supplemental diazepam and";

        int limit=50;
        String preTag="<b>";
        String postTag="</b>";
        String result = getSegmentText(text,limit,preTag,postTag);
        System.out.println(result);
    }

    protected static String getSegmentText(String text, int limit, String preTag, String postTag){
        Pattern p = Pattern.compile(preTag+"([^"+postTag+"])+"+postTag);
        Matcher m = p.matcher(text);

        BreakIterator bi = BreakIterator.getWordInstance();
        bi.setText(text);

        List<Integer> highlightStart = new ArrayList<>();
        List<Integer> highlightEnd = new ArrayList<>();

        while (m.find()){
            //String hit = m.group();
            int match_word_end = bi.following(m.end());
            if(match_word_end == -1){
                match_word_end = m.end();
            }
            int match_word_start = bi.preceding(m.start());
            if(match_word_start == -1){
                match_word_start = m.start();
            }

            //System.out.println("Word: "+hit+", starting at: "+match_word_start+", ending at: "+match_word_end+", length: "+(match_word_end-match_word_start));
            highlightStart.add(match_word_start);
            highlightEnd.add(match_word_end);
        }

        if(highlightStart.size() > 0){
            if(highlightStart.size() == 1){
                int lastBoundaryFollowingHighlightWord = highlightEnd.get(0);
                int lastBoundaryPrecedingHighlightWord = highlightStart.get(0);
                int totalLength = lastBoundaryFollowingHighlightWord - lastBoundaryPrecedingHighlightWord;

                do{
                    int forward = bi.following(lastBoundaryFollowingHighlightWord);
                    int backward = bi.preceding(lastBoundaryPrecedingHighlightWord);

                    //Words after highlight
                    if(forward != BreakIterator.DONE && totalLength <= limit){
                        lastBoundaryFollowingHighlightWord = forward;
                    }

                    //Words before highlight
                    if(backward != BreakIterator.DONE && totalLength <= limit){
                        lastBoundaryPrecedingHighlightWord = backward;
                    }

                    totalLength = lastBoundaryFollowingHighlightWord - lastBoundaryPrecedingHighlightWord;
                    if(forward == BreakIterator.DONE && backward == BreakIterator.DONE){
                        break;
                    }
                }while (totalLength <= limit);

                while(!Character.isLetterOrDigit(text.charAt(lastBoundaryPrecedingHighlightWord))
                        && (preTag == null || !text.substring(lastBoundaryPrecedingHighlightWord).startsWith(preTag))){
                    int rev = bi.preceding(lastBoundaryPrecedingHighlightWord);
                    if(rev != BreakIterator.DONE){
                        lastBoundaryPrecedingHighlightWord = rev;
                    }else{
                        break;
                    }
                }

                while(!Character.isLetterOrDigit(text.charAt(lastBoundaryFollowingHighlightWord-1))){
                    int fw = bi.following(lastBoundaryFollowingHighlightWord);
                    if(fw != BreakIterator.DONE){
                        lastBoundaryFollowingHighlightWord = fw;
                    }else{
                        break;
                    }
                }

                return text.substring(lastBoundaryPrecedingHighlightWord, lastBoundaryFollowingHighlightWord);
            }else{
                int maxStart = 0;
                int maxEnd = Math.min(limit, text.length());
                int maxIncludeCount = 0;

                BreakIterator bie = BreakIterator.getWordInstance();
                bie.setText(text);

                for(int s = bi.first(), e = bie.following(Math.min(limit, text.length()));
                    e != BreakIterator.DONE;
                    s = bi.next(), e = bie.following(e)

                ){

                    int matchedHighlights = 0;
                    for (int i=0; i<highlightStart.size(); i++){
                        if(s <= highlightStart.get(i) && highlightEnd.get(i) <= e){
                            matchedHighlights++;
                        }
                    }

                    //System.out.println("Start: "+s+", End: "+e+", Length: "+(e-s)+", Matched: "+matchedHighlights+" for substring: ["+text.substring(s, e)+"]");

                    if(matchedHighlights >= maxIncludeCount){
                        maxIncludeCount = matchedHighlights;
                        maxStart = s;
                        maxEnd = e;
                    }
                }

                while(!Character.isLetterOrDigit(text.charAt(maxStart))){
                    int rev = bi.preceding(maxStart);
                    if(rev != BreakIterator.DONE){
                        maxStart = rev;
                    }else{
                        break;
                    }
                }

                while(!Character.isLetterOrDigit(text.charAt(maxEnd-1))){
                    int fw = bie.following(maxEnd);
                    if(fw != BreakIterator.DONE){
                        maxEnd = fw;
                    }else{
                        break;
                    }
                }

                return text.substring(maxStart, maxEnd);
            }
        }
        return text;
    }
}
