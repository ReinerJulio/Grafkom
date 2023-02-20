package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.awt.*;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL15.*;

public class Rectangle extends Object2d {
    List<Integer>index;
    int ibo;

    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,List<Integer>index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
    }
    public void draw(){
        drawSetup();
        //draw the vertices
        //optional
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glDrawElements(GL_TRIANGLES,index.size(),GL_UNSIGNED_INT,0);

        //wajib
        //GL_LINE
        //GL_liNE_STRIP
        //GL_liNE_LOOP
        //GL_liNE_TRIANGLES
        //GL_liNE_TRIANGLES_FAN
        //GL_POINT
        //glDrawArrays(GL_TRIANGLE_FAN,0,vertices.size());
        //frst mau mulai dri index keberapa
        //gambar emua vertices.size

    }
}