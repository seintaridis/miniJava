//
// Generated by JTB 1.3.2 DIT@UoA patched
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "HSTORE"
 * f1 -> Temp()
 * f2 -> IntegerLiteral()
 * f3 -> Temp()
 */
public class HStoreStmt implements Node {
   public NodeToken f0;
   public Temp f1;
   public IntegerLiteral f2;
   public Temp f3;

   public HStoreStmt(NodeToken n0, Temp n1, IntegerLiteral n2, Temp n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public HStoreStmt(Temp n0, IntegerLiteral n1, Temp n2) {
      f0 = new NodeToken("HSTORE");
      f1 = n0;
      f2 = n1;
      f3 = n2;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

