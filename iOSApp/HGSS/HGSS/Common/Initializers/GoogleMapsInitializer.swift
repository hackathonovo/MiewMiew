//
//  GoogleMapsInitializer.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import GoogleMaps

class GoogleMapsInitializer: Initializable {
    
    func setup() {
        GMSServices.provideAPIKey("AIzaSyA0Sx8jszTvnm8ZyzAJSMRW97We3YPbi78")
    }
}
