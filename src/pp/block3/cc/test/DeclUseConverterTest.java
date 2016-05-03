package pp.block3.cc.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import pp.block3.cc.antlr.CalcAttrLexer;
import pp.block3.cc.symbol.DeclUseConverter;
import pp.block3.cc.symbol.DeclUseConverter.Error;
import pp.block3.cc.symbol.DeclUseLexer;

public class DeclUseConverterTest {

    private final ParseTreeWalker walker = new ParseTreeWalker();
    private final DeclUseConverter decl = new DeclUseConverter();

    @Test
    public void test() {
//        test("(D:aap (U:aap D:noot D:aap (U:noot) (D:noot U:noot)) U:aap)");
//        test("(\n\tD:aap \n\t(\n\t\tU:aap \n\t\tD:noot \n\t\tD:aap \n\t\t(\n\t\t\tU:noot\n\t\t) \n\t\t(\n\t\t\tD:noot \n\t\t\tU:noot\n\t\t)\n\t) \n\tU:aap\n)");
//        test("(D:Foo (U:Foo D:Bar) D:Baz (((U:Baz))))");
//        test("(D:Foo (U:Foo U:Bar) D:Baz (((U:Bas))))", decl.new Error("U:Bar not declared", 1, 16), decl.new Error("U:Bas not declared", 1, 32));
//        test("(\n\tD:aap \n\t(\n\t\tU:aap \n\t\tD:noot \n\t\tD:aap \n\t\t(\n\t\t\tU:noot\n\t\t) \n\t\t(\n\t\t\tD:noot \n\t\t\tU:noot\n\t\t)\n\t) \n\tD:aap\n)", decl.new Error("D:aap already declared", 15, 3));
        test("../symbol/programs/DeclUse1");
        test("../symbol/programs/DeclUse2");
        test("../symbol/programs/DeclUse3");
        test("../symbol/programs/DeclUse4");
        test("../symbol/programs/DeclUse5");
    }

    private void test(String filename, Error... expected) {


        Boolean ok = true;
        List<Error> errors = parseDeclUse(filename);
        System.out.println(filename.split("/")[filename.split("/").length - 1]);
        for (Error e : errors) {
            System.out.println(e.toString());
        }
        assertTrue(expected.length == errors.size());
        for (int i = 0; i < expected.length; i++) {
            if (!errors.get(i).equals(expected[i])) {
                ok = false;
            }
        }

        assertTrue(ok);
    }

    private List<Error> parseDeclUse(String filename) {
        CharStream chars = null;
        try {
            chars = new ANTLRInputStream(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new DeclUseLexer(chars);
        decl.init();
        return decl.parse(lexer);
    }
}
