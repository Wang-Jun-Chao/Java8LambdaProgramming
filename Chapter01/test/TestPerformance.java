import com.java.lambda.Album;
import com.java.lambda.Artist;
import com.java.lambda.SampleData;
import com.java.lambda.Track;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 09:30
 */
public class TestPerformance {
    @Test
    public void allMembers() {
        Album album = new Album("foo", Collections.<Track>emptyList(), Collections.singletonList(SampleData.theBeatles));
        Set<Artist> musicians = album.getAllMusicians().collect(Collectors.toSet());
        Set<Artist> expectedMusicians = new HashSet<>(SampleData.membersOfTheBeatles);
        System.out.println(musicians);
        System.out.println(expectedMusicians);

//        expectedMusicians.add(SampleData.theBeatles);
        Assert.assertEquals(expectedMusicians, musicians);
    }
}
