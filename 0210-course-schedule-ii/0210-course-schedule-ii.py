from collections import defaultdict

class Solution:
    def findOrder(self, numCourses, prerequisites):
              # Define constants for course status
        NOT_STARTED, IN_PROGRESS, COMPLETED = 0, 1, 2

        # Define a DFS function to find the order of courses
        def finish_order(course, pre_graph, course_status, current_order):
            if course_status[course] == IN_PROGRESS:
                # Cycle detected
                return []
            if course_status[course] == COMPLETED:
                # Already processed this course, no cycle here
                return None

            # Mark the course as in progress
            course_status[course] = IN_PROGRESS

            # Recursively visit prerequisites for the current course
            for pre_course in pre_graph.get(course, []):
                result = finish_order(pre_course, pre_graph, course_status, current_order)
                if result == []:  # Cycle detected
                    return []

            # Mark the course as completed
            course_status[course] = COMPLETED
            current_order.append(course)
            return None  # Indicate that we've processed this course successfully

        # Create an adjacency list to represent the prerequisites
        pre_graph = defaultdict(list)
        for dest, src in prerequisites:
            pre_graph[src].append(dest)

        # Initialize the course status for all courses
        course_status = [NOT_STARTED] * numCourses
        order = []

        # Perform DFS for each course to find the order
        for course in range(numCourses):
            if course_status[course] == NOT_STARTED:
                if finish_order(course, pre_graph, course_status, order) == []:
                    return []  # Cycle detected, return an empty list

        # If we reach here, no cycles were detected, and we have a valid order
        return order[::-1]  # Reverse the order to get the correct order of courses


        # Create an adjacency list (graph) to represent the prerequisites
#         pre_graph = defaultdict(list)
#         for pair in prerequisites:
#             pre_graph[pair[1]].append(pair[0])
    
    
        pre_graph = defaultdict(list)

        # Function to add an edge to the adjacency list
        def add_edge(adj, from_vertex, to_vertex):
            if from_vertex not in adj:
                adj[from_vertex] = []
            adj[from_vertex].append(to_vertex)

        # Populate the adjacency list
        for pair in prerequisites:
            add_edge(pre_graph, pair[1], pair[0])
            # If you want to include the nodes with no outgoing edges:
            # if pair[0] not in pre_graph:
            #     pre_graph[pair[0]] = []
    
        # Initialize the course status for all courses
        course_status = [NOT_STARTED] * numCourses
       # # Print the adjacency list
        # for node in pre_graph:
        #     print(f"Node {node}: {pre_graph[node]}")
        order = []

        # Perform DFS for each course to find the order
        for course in range(numCourses):
            current_order = finish_order(course, pre_graph, course_status, order)
            if not current_order:
                return []  # Cycle detected, return an empty list

        return order  # Reverse the order to get the correct order of courses