#version 330

out vec4 fragColor;
in vec4 out_color;
void main()
{
    // vec4(red,green,blue,alpha)
    // rgba -> red 100/255
    fragColor = out_color;
}