package theory.challenges.tree.dfs.foldertree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Folder {

    String name;
    List<Folder> subFolders;


    public Folder(String name) {
        this.name = name;
    }

    public void addFolder(Folder folder) {
        if (subFolders == null) {
            subFolders = new ArrayList<>();
        }
        subFolders.add(folder);
    }

}

class FolderTree {
    Folder rootFolder;

    public boolean search(String folderName) {
        if (rootFolder != null) {
            Queue<Folder> foldersToCheck = new ArrayDeque<>();
            foldersToCheck.add(rootFolder);
            while (!foldersToCheck.isEmpty()) {
                Folder folder = foldersToCheck.remove();
                if (folderName.equals(folder.name)) {
                    return true;
                }
                if (folder.subFolders != null) {
                    foldersToCheck.addAll(folder.subFolders);
                }
            }
        }
        return false;
    }


    public class FolderTreeNodeTest {

        FolderTree folderTree;


        @Before
        public void setup() {
            folderTree = new FolderTree();

            /*Root*/
            Folder disk = new Folder("Disk");
            folderTree.rootFolder = disk;

            /*C & D */
            Folder c = new Folder("C");
            Folder d = new Folder("D");
            disk.addFolder(c);
            disk.addFolder(d);

            /*C Drive*/
            Folder document = new Folder("Document");
            Folder programFiles = new Folder("ProgramFiles");
            Folder java = new Folder("java");
            Folder bin = new Folder("bin");
            java.addFolder(bin);
            programFiles.addFolder(java);
            c.addFolder(programFiles);
            c.addFolder(document);


            /*D Drive*/
            Folder movies = new Folder("movies");
            Folder action = new Folder("action");
            Folder song = new Folder("song");
            movies.addFolder(action);
            d.addFolder(movies);
            d.addFolder(song);
        }


        @Test
        public void testSearch() {
            Assert.assertTrue(folderTree.search("song"));
            Assert.assertFalse(folderTree.search("invalid"));
        }
    }


}
