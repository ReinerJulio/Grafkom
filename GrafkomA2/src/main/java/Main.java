import Engine.Object2d;
import Engine.Rectangle;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window =
            new Window(500,500,"Segitiga Bertua");

    private ArrayList<Object2d> objects = new ArrayList<>();

    private ArrayList<Object2d> objectsRectangle = new ArrayList<>();

    public void init(){
        window.init();
                GL.createCapabilities();

        //code
        objects.add(new Object2d(Arrays.asList(
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/sceneWithVerticesColor.frag",GL_FRAGMENT_SHADER)
                ),
        new ArrayList<>(
                List.of(
                        new Vector3f(0.0f,0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, -0.5f),
                        new Vector3f(0.5f, -0.5f, 0.0f)
                )
        ), new ArrayList<>(
                List.of(
                        new Vector3f(1.0f,0.0f, 0.0f),
                        new Vector3f(0.0f, 1.0f, 0.0f),
                        new Vector3f(0.0f, 0.0f, 1.0f)
                )
        )));



        objectsRectangle.add(new Rectangle(Arrays.asList(
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.0f, 0.0f),
                                new Vector3f(1.0f, 0.0f, 0.0f),
                                new Vector3f(0.0f, 0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0,1,2,1,2,3)
                )
        );


    }
    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f,
                    0.0f,0.0f,
                    0.0f);
            GL.createCapabilities();

            //code
            for (Object2d object: objects){
                object.drawWithVerticesColor();
            }

            for (Object2d object: objectsRectangle){
                object.draw();
            }
            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will
            glfwPollEvents();
        }
    }
    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}