public class SimpleVector implements Vector
{
    float x;
    float y;
    float z;
    public SimpleVector(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void accept(VectorConsumer consumer)
    {
        consumer.consume(x, y, z);
    }    
}
