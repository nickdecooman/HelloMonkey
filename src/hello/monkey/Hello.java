package hello.monkey;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author nickdecooman
 */
public class Hello extends SimpleApplication {
    
    private Node pivot;
    private AnalogListener analogListener;
 
    public Hello(){
        analogListener = new AnalogListener() {
            public void onAnalog(String name, float value, float tpf) {
                pivot.rotate(0, value*1f, 0);
                //rootNode.rotate(0, value*1f, 0);
            }
        };
    }
    
    @Override
    public void simpleInitApp() {
 
        // Create a blue box at position (1, -1, 1)
        Box box1 = new Box(1,1,1);
        Geometry blueBox = new Geometry("Box", box1);
        blueBox.setLocalTranslation(new Vector3f(1,-1,1));
        Material mat1 = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.Blue);
        blueBox.setMaterial(mat1);
 
        // Create a green box at position (1, 1, 1)
        Box box2 = new Box(1,1,1);      
        Geometry greenBox = new Geometry("Box", box2);
        greenBox.setLocalTranslation(new Vector3f(1,1,1));
        Material mat2 = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Green);
        greenBox.setMaterial(mat2);
        
        // Create a red box at position (4, -1, 1)
        Box box3 = new Box(1,1,1);      
        Geometry redBox = new Geometry("Box", box3);
        redBox.setLocalTranslation(new Vector3f(4,-1,1));
        Material mat3 = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat3.setColor("Color", ColorRGBA.Red);
        redBox.setMaterial(mat3);
 
        // Create scene graph
        pivot = new Node("pivot");
        rootNode.attachChild(pivot);
        rootNode.attachChild(redBox);
        pivot.attachChild(blueBox);
        pivot.attachChild(greenBox);
        
        // Initialize rotate listener
        flyCam.setEnabled(false);
        inputManager.addMapping("Rotate", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(analogListener, "Rotate");
    }
    
}