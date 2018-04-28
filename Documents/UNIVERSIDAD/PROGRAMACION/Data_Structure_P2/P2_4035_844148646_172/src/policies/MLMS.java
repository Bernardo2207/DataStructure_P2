package policies;
//Multiple Lines Multiple Servers
public class MLMS {
	int posts;

	/*Under this policy, each service post has its own waiting line (one line per server).
	 *  Once a person enters a waiting line, that person cannot transfer to another line, 
	 *  even if one becomes empty. When a new person arrives looking for service, the person
	 *   will choose the first line that has minimum number of persons waiting, as per the indexes
	 *  identifying the corresponding service posts. If a line becomes empty, then the server 
	 *  there remains idle until a new customer arrives and selects that particular line. 
	 *  (This happens often in lines for cars to pay at the toll gate on a highway; once you are
	 *  in a line, it is hard to change to another, even if one becomes empty.)
*/
}
