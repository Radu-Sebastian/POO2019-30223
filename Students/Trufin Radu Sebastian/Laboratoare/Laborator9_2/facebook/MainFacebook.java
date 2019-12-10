package facebook;

public class MainFacebook 
{
	public static void main(String args[])
	{
		FacebookAccount oltean = new FacebookAccount("Zoican Denis",20,"Oltenia");
		FacebookAccount taicamiu = new FacebookAccount("Trufin Valentin",49,"Radauti");
		FacebookAccount bouaru = new FacebookAccount("Bouaru Radu",20,"Radauti");
		FacebookAccount myFriend = new FacebookAccount("Vlad Rusu",20,"Galati");
		
		oltean.addFriend(taicamiu);
		oltean.addFriend(bouaru);
		oltean.showFriends();
		oltean.removeFriend(bouaru);
		oltean.showFriends();
		myFriend.showFriends();
		oltean.addFriend(myFriend);
		oltean.addFriend(bouaru);
		oltean.friendLocation("Radauti");
	}
}
