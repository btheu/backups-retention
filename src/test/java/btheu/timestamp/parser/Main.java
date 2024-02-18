package btheu.timestamp.parser;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import timestamp.TimestampLexer;
import timestamp.TimestampParser;

public class Main {

    public static void main(String[] args) {

        String s = "2024";
        CodePointCharStream fromString = CharStreams.fromString(s);

        TimestampLexer lex = new TimestampLexer(fromString);

        CommonTokenStream tokens = new CommonTokenStream(lex);

        TimestampParser parser = new TimestampParser(tokens);

        try {

            TimestampParser.ExpressionContext expr = parser.expression();

            System.out.println(expr.toStringTree());

            //  System.out.println(EpisodeParser.parse(s));

            // show AST in GUI
            JFrame frame = new JFrame("Antlr AST");
            JPanel panel = new JPanel();
            TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), expr);
            viewr.setScale(1.2);// scale a little
            panel.add(viewr);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2048, 600);
            frame.setVisible(true);

        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }

}
