//
//  UIFont.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import Foundation
import UIKit

enum FontName: String {
    case latoRegular = "Lato-Regular"
    case latoBold = "Lato-Bold"
}

extension UIFont {
    
    class func font(name: FontName, size: Int) -> UIFont {
        return UIFont(name: name.rawValue , size: CGFloat(size))!
    }
}
