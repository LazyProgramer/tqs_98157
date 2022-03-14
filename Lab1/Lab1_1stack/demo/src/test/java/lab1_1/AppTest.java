package lab1_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.internal.matchers.ThrowableMessageMatcher;

import lab1_1.SimpleStack;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @DisplayName("Test MessageService.get()")
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private SimpleStack stackTest;

    @BeforeEach
    public void setUp(){
        this.stackTest = new SimpleStack();
    }

    @AfterEach
    public void tearDown(){
        this.stackTest = null;
    }

    @DisplayName("A stack is empty on construction")
    @Test
    public void isStackEmpty(){
        //assertEquals(this.stackTest.isEmpty(), true);
        assertTrue( this.stackTest.isEmpty());
    }

    @DisplayName("A stack has size 0 on construction")
    @Test
    public void stackSize(){
        assertEquals(0, this.stackTest.size());
    }

    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    public void stackSizeN(){
        for(int i=0;i<5;i++){
            this.stackTest.push(1);
        }
        assertFalse(this.stackTest.isEmpty());
        assertEquals(5, this.stackTest.size());
    }

    @DisplayName("If one pushes x then pops, the value popped is x")
    @Test
    public void lastPushPop(){
        Object o = new Object();
        this.stackTest.push(o);
        assertEquals(o, this.stackTest.pop());
    }

    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    public void lastPushPeek(){
        Object o = new Object();
        this.stackTest.push(o);
        int size = this.stackTest.size();
        assertEquals(o, this.stackTest.peek());
        assertEquals(size, this.stackTest.size());
    }

    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    public void popTillEmpty(){
        int n = 5;
        for(int i=0;i<n;i++){
            this.stackTest.push(1);
        }

        for(int i=0;i<n;i++){
            this.stackTest.pop();
        }

        assertTrue(this.stackTest.isEmpty());
        assertEquals(0, this.stackTest.size());
    }

    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    @Test
    public void popEmpty(){
        assertThrows(NoSuchElementException.class, () -> {this.stackTest.pop();});
    }

    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    public void peekEmpty(){
        assertThrows(NoSuchElementException.class, () -> {this.stackTest.peek();});
    }

    @DisplayName("For bounded stacks only:pushing onto a full stack does throw an IllegalStateException")
    @Test
    public void boundedStack(){
        this.stackTest = new SimpleStack(0);
        
        assertThrows(IllegalStateException.class, () -> {this.stackTest.push(1);});
    }
}
